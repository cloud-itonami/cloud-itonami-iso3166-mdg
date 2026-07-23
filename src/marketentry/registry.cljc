(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-procurement market-entry
  filing -- every jurisdiction assigns its own format. This namespace
  does NOT invent one; it builds a jurisdiction-scoped sequence number
  and validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `armp-exclusion-duration-lawful?` / `armp-ineligibility-satisfied?`
  are the pure re-derivation of this vertical's flagship check (Loi
  n°2016-055, Article 90 §IX-X): ARMP's own quarterly-published
  ineligibility list caps ordinary ('temporaire') exclusion at 5 years,
  and the ONLY lawful basis for a longer/'définitive' exclusion is a
  formal ARMP récidive finding.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real procurement portal. It builds the RECORD an
  operator would keep, not the act of submitting a portal registration
  itself (that is `marketentry.operation`'s `:filing/submit`, always
  human-gated -- see README Actuation)."
  (:require [clojure.string :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  (+ (double base-fee)
     (* (double monthly-rate) (double monitoring-months))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (== (double claimed-fee) (compute-engagement-fee engagement)))

(def armp-exclusion-statutory-cap-years
  "Loi n°2016-055, Article 90 §IX: 'La sanction de l'inéligibilité de la
  commande publique ne peut dépasser cinq ans.'"
  5)

(defn armp-exclusion-duration-lawful?
  "Article 90 §IX: ordinary ('temporaire') ARMP ineligibility may not
  exceed 5 years, UNLESS an ARMP récidive (repeat-offense) finding is on
  record, in which case an exclusion définitive (permanent) is lawful.
  Ground-truth re-derivation, independent of whatever the advisor's
  proposal claims about the operator's current standing -- no recorded
  duration at all (never excluded) is trivially lawful."
  [{:keys [armp-recidivism-finding? armp-prior-exclusion-duration-years]}]
  (or (true? armp-recidivism-finding?)
      (nil? armp-prior-exclusion-duration-years)
      (<= armp-prior-exclusion-duration-years armp-exclusion-statutory-cap-years)))

(defn armp-ineligibility-satisfied?
  "Does `engagement` independently satisfy the ARMP-clearance gate --
  i.e. either it does not itself require ARMP clearance (a pure
  private-investment engagement that never goes through public
  procurement), or the operator is not CURRENTLY on ARMP's own Article
  90 §X quarterly-published ineligibility list AND any exclusion
  duration on record is lawful under Article 90 §IX? Pure re-derivation
  of the same test `marketentry.governor`'s flagship check applies,
  exposed here for reuse outside the governor (e.g. by
  `marketentry.marketentryllm`'s own confidence estimate)."
  [{:keys [requires-armp-clearance? on-armp-ineligibility-list?] :as engagement}]
  (or (not requires-armp-clearance?)
      (and (not (true? on-armp-ineligibility-list?))
           (armp-exclusion-duration-lawful? engagement))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a filing package. Pure
  function -- does not touch any real procurement portal."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper-case jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting a filing
  (always human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper-case jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
