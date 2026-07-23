(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 340000 :monthly-rate 19000 :monitoring-months 12 :claimed-fee 568000.0}]
    (is (== 568000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 340000 :monthly-rate 19000 :monitoring-months 12 :claimed-fee 700000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "MDG" 0)
        s (registry/register-submit "eng-1" "MDG" 0)]
    (is (= "MDG-DFT-000000" (get d "draft_number")))
    (is (= "MDG-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "MDG" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))

(deftest armp-exclusion-duration-lawful-no-record
  (testing "never excluded (no duration on record) is trivially lawful"
    (is (true? (registry/armp-exclusion-duration-lawful?
                {:armp-recidivism-finding? false :armp-prior-exclusion-duration-years nil})))))

(deftest armp-exclusion-duration-lawful-within-cap
  (testing "a 5-year (or shorter) exclusion is lawful without any récidive finding -- Article 90 §IX's own boundary"
    (is (true? (registry/armp-exclusion-duration-lawful?
                {:armp-recidivism-finding? false :armp-prior-exclusion-duration-years 5})))
    (is (true? (registry/armp-exclusion-duration-lawful?
                {:armp-recidivism-finding? false :armp-prior-exclusion-duration-years 2})))))

(deftest armp-exclusion-duration-unlawful-beyond-cap-without-recidivism
  (testing "a >5-year exclusion with no récidive finding exceeds Article 90 §IX's own statutory cap"
    (is (false? (registry/armp-exclusion-duration-lawful?
                 {:armp-recidivism-finding? false :armp-prior-exclusion-duration-years 7})))))

(deftest armp-exclusion-duration-lawful-with-recidivism
  (testing "a récidive finding is the ONLY lawful basis for exceeding the 5-year cap (Article 90 §IX)"
    (is (true? (registry/armp-exclusion-duration-lawful?
                {:armp-recidivism-finding? true :armp-prior-exclusion-duration-years 20})))))

(deftest armp-ineligibility-satisfied-not-required
  (testing "an engagement that does not itself require ARMP clearance is satisfied regardless of the other fields"
    (is (true? (registry/armp-ineligibility-satisfied?
                {:requires-armp-clearance? false
                 :on-armp-ineligibility-list? true
                 :armp-recidivism-finding? false
                 :armp-prior-exclusion-duration-years 99})))))

(deftest armp-ineligibility-satisfied-clean
  (is (true? (registry/armp-ineligibility-satisfied?
              {:requires-armp-clearance? true
               :on-armp-ineligibility-list? false
               :armp-recidivism-finding? false
               :armp-prior-exclusion-duration-years nil}))))

(deftest armp-ineligibility-unsatisfied-currently-listed
  (is (false? (registry/armp-ineligibility-satisfied?
               {:requires-armp-clearance? true
                :on-armp-ineligibility-list? true
                :armp-recidivism-finding? false
                :armp-prior-exclusion-duration-years nil}))))

(deftest armp-ineligibility-unsatisfied-unlawful-duration
  (testing "not currently listed, but an unlawfully-long prior exclusion on record -- still unsatisfied"
    (is (false? (registry/armp-ineligibility-satisfied?
                 {:requires-armp-clearance? true
                  :on-armp-ineligibility-list? false
                  :armp-recidivism-finding? false
                  :armp-prior-exclusion-duration-years 7})))))
