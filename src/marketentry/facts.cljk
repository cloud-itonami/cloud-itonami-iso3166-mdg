(ns marketentry.facts
  "Madagascar (MDG) market-entry / public-procurement catalog.

  Every fact under \"MDG\" below is grounded ONLY in primary sources this
  iteration actually curl/pdftotext-fetched and read directly this
  session (2026-07-22/23) -- ARMP's own government site (`armp.mg` /
  `app.armp.mg`), the actual Loi n°2016-055 Code des Marchés Publics PDF
  that ARMP's own site links to, EDBM's own government site (`edbm.mg`,
  the Economic Development Board of Madagascar), the Direction Générale
  des Impôts' own government site (`impots.mg`), and (for the Code du
  Travail only, an explicitly-flagged exception -- see below) a
  Wayback Machine snapshot of a private Francophone-African legal-text
  aggregator. Nothing below is paraphrased from training-data memory;
  where this iteration could not independently confirm a specific fact,
  that gap is stated explicitly rather than filled with a
  plausible-sounding invention.

  **Madagascar is NOT an OHADA member state -- independently verified,
  not assumed.** This iteration re-fetched OHADA's own 'Les Etats
  membres de l'OHADA' page (`https://www.ohada.org/les-etats-membres-de-
  lohada/`, fetched directly this session both via WebFetch and via a
  direct curl+grep of the raw HTML) and confirmed its own exact member
  list, verbatim: \"Bénin, Burkina Faso, Cameroun, Centrafrique, Comores,
  Congo, Cote d'Ivoire, Gabon, Guinée, Guinée Bissau, Guinée Equatoriale,
  Mali, Niger, RDC, Sénégal, Tchad, Togo\" -- 17 states, Madagascar named
  in NONE of them (a raw-HTML `grep -io madagascar` independently returned
  zero matches). This is the exact house lesson this fleet has gotten
  wrong before for other Francophone African nations (assuming OHADA
  membership, or a regulator's acronym, by analogy instead of checking):
  this catalog does NOT borrow the `-ben`/`-caf`/`-cog`/`-gin`/`-gnb`
  siblings' OHADA/AUSCGIE (companies) or AUDCG (RCCM) citations. Madagascar
  runs its OWN national companies-law and business-registry regime (own
  law numbers below, own registry name RCS -- Registre du Commerce et
  des Sociétés -- not OHADA's RCCM).

  Sources actually fetched and read this session:

  - **Public procurement -- regulator name independently verified, not
    assumed.** `https://app.armp.mg/` (and `https://www.armp.mg/`, same
    content) is LIVE and reachable (HTTP 200) but is now a thin Angular
    single-page e-Government-Procurement application with almost no
    server-rendered text -- its own `<title>`/meta tags (fetched
    directly, verbatim): \"EGP | E-Government ProcurementEGP\" /
    `<meta name=\"description\" content=\"EGP | E-Government Procurement
    (e-GP) portal Madagascar\">`, `og:url` `http://egp.ingenosya.mg/`.
    This confirms ARMP operates a REAL national e-procurement
    TRANSACTIONAL portal (unlike this fleet's `-moz` sibling, which found
    no such portal for Mozambique) but the live SPA exposes no legal
    text to a static fetch. This iteration therefore used the Wayback
    Machine to read ARMP's own site content from when it was still
    server-rendered (disclosed here explicitly, per this fleet's
    fallback discipline): a 2010-04-16 snapshot
    (`http://web.archive.org/web/20100416113232/http://www.armp.mg/`) of
    ARMP's own homepage, own text, verbatim (Directeur Général's own
    welcome message): \"D'où la création de l'Autorité de Régulation des
    Marchés Publics en 2006... le nouveau code des Marchés publics
    malgache\" -- independently confirming ARMP's full name AND that it
    administers a Code des Marchés Publics. A later snapshot of the
    SAME site's own \"Textes fondamentaux\" -> \"Les textes à caractère
    général\" page
    (`http://web.archive.org/web/20211216202249/http://armp.mg/?q=les_textes_caract_re_g_n_ral`,
    ARMP's own document-attachment listing, own text, verbatim) lists
    THREE dated attachments: \"Loi 2004-009 du 26 Juillet 2004 portant
    code des Marchés Publics\", \"Décret 2005-215 portant organisation et
    fonctionnement de l'ARMP\", and \"Loi 2016-055 du 25 Janvier 2017
    portant Code des Marchés Publics (Nouveau)\" -- i.e. ARMP's OWN site
    identifies the 2016-055 law as the CURRENT ('Nouveau') code,
    superseding the 2004-009 one. This iteration independently
    downloaded ARMP's own linked PDF of that current law
    (`http://armp.mg/sites/default/files/Loi_2016-055_CMP.pdf`, via the
    same Wayback capture -- a real, machine-readable, native-text-layer
    PDF; `pdftotext` succeeded, 2329 lines) and read its own primary
    text directly, confirming: title page \"PRESIDENCE DE LA REPUBLIQUE
    ... Loi n° 2016-055 portant Code des Marchés Publics\"; Article 18
    ('Organisation et fonctionnement'), own text, verbatim: \"Il est
    institué une autorité administrative indépendante dotée de pouvoirs
    d'administration, de décision et de sanction, dénommée Autorité de
    Régulation des Marchés Publics ... dotée de la personnalité
    juridique, jouit d'une autonomie administrative et financière\" --
    HIGH confidence, ARMP's own full name and independent-authority
    status confirmed directly in the law's own operative text (not
    merely a plausible-sounding acronym assumed by analogy to another
    Francophone country's regulator). The law's own final article (own
    text, verbatim): \"La présente loi sera publiée au Journal Officiel
    de la République ... Promulguée à Antananarivo, le 25 janvier 2017\"
    -- an exact match to ARMP's own document-listing date above (own two
    independent presentations of the same fact, cross-confirmed). This
    iteration ALSO independently cross-confirmed the SAME law/date via a
    SECOND, unrelated official Malagasy source (EDBM's own
    'Cadre juridique' legislative index, see below), which likewise cites
    \"Loi n°2016-055 du 25 janvier 2017 portant Code des marchés publics\"
    as the current procurement code across every one of its own
    snapshots checked from 2021 through 2025 -- no newer replacement law
    is named on EITHER official index checked this session.
  - **Candidates non admis à concourir -- Exclusions et incapacités**
    (Article 21 of Loi n°2016-055, own text, OWN primary-text PDF read
    directly, verbatim): item (c) bars \"Les personnes physiques ou
    morales qui n'ont pas souscrit à leurs obligations fiscales ou para
    fiscales à la date limite fixée pour le dépôt des offres\" -- i.e.
    fiscal/tax-registration standing (NIF, see below) is a DIRECT,
    categorical precondition of competing for public procurement, not a
    wholly separate regime; item (i) additionally bars \"les personnes
    physiques ou morales qui ont fait l'objet d'exclusion temporaire ou
    définitive prononcée par l'Autorité de Régulation des Marchés
    Publics\", with 'les modalités d'exclusion temporaire ou définitive
    ... définies par voie réglementaire'.
  - **This vertical's flagship mechanism -- ARMP's own quarterly-
    published ineligibility list, with a statutory duration cap and a
    récidive escape hatch (see `marketentry.governor` /
    `marketentry.registry`).** Article 90 ('Des sanctions à l'encontre
    du soumissionnaire ou du titulaire'), own text, OWN primary-text PDF
    read directly, verbatim: \"IX. La sanction de l'inéligibilité de la
    commande publique ne peut dépasser cinq ans. Par contre, en cas de
    récidive, l'exclusion définitive peut être prononcée par l'autorité
    de régulation des marchés publics. X. L'autorité de régulation des
    marchés publics établit trimestriellement une liste des personnes
    physiques et morales inéligibles à la commande publique. Cette
    liste est régulièrement mise à jour, transmise aux autorités
    contractantes et publiée au Journal des Marchés Publics et au
    Journal Officiel.\" This is a genuinely different shape from this
    fleet's other flagship checks documented in sibling catalogs (a
    plain boolean debarment registry, or a percentage-of-value pecuniary
    sanction range): a TIME-BOUNDED exclusion with (a) a hard 5-year
    statutory ceiling on ordinary ('temporaire') ineligibility, (b) a
    named escape hatch -- only a formal ARMP récidive finding can make an
    exclusion 'définitive' (permanent/unbounded), and (c) a mandatory
    quarterly-publication transparency requirement (Journal des Marchés
    Publics + Journal Officiel) this catalog does not need to take on
    faith -- ARMP's own document-listing pages (above) independently
    corroborate that both the Journal des Marchés Publics and the
    ARMP text-publication practice are real, live artifacts, not merely
    claimed.
  - **Business registration -- EDBM as Madagascar's own Guichet Unique
    (one-stop-shop), independently confirmed, not assumed to mirror
    another country's model.** `https://www.edbm.mg/` is LIVE (HTTP 200)
    but, like ARMP's site, is now a thin React single-page application
    with almost no server-rendered text (`<title>Economic Development
    Board of Madagascar</title>` only, confirmed directly). This
    iteration used the Wayback Machine to read EDBM's own site content
    from before the SPA migration (disclosed explicitly): a 2021-01-21
    snapshot (`http://web.archive.org/web/20210121023428/https://edbm.mg/`)
    of EDBM's own homepage, own text, verbatim: \"L'Economic Development
    Board of Madagascar (EDBM) est votre partenaire de référence pour vos
    investissements à Madagascar. En tant qu'Agence de Promotion des
    Investissements (API), l'EDBM s'est fixé pour objectifs de renforcer
    la compétitivité du secteur privé malgache, d'accroître
    l'Investissement Étranger Direct (IED)...\" -- and its OWN top-level
    navigation menu (same snapshot, own text) has a dedicated \"GUICHET
    UNIQUE\" section listing, among other services: \"Création de
    société\", \"Modification du RCS\", \"Modification de la carte
    statistique\" -- i.e. EDBM's own site directly confirms it is the
    one-stop-shop FRONT END for both company creation AND RCS (Registre
    du Commerce et des Sociétés -- Madagascar's OWN companies registry,
    not OHADA's RCCM) maintenance, exactly as this fleet's `-gnb`/`-moz`
    siblings found for their own countries' guichet unique / BAU
    institutions. A 2021-01-24 snapshot of EDBM's own \"A propos\" page
    (`http://web.archive.org/web/20210124221102/https://edbm.mg/a-propos/`,
    own text, verbatim) independently confirms EDBM's self-description:
    \"L'Agence officielle de promotion des investissements à Madagascar\".
    This iteration did NOT independently find EDBM's own founding
    decree/law number on either page fetched this session -- an honest
    gap, not filled by guessing a decree number.
  - **EDBM's own \"Cadre juridique\" (Legal Framework) index page is this
    session's single richest source and independently CROSS-CONFIRMS
    the ARMP procurement-code finding above.** A 2021-06-25 snapshot
    (`http://web.archive.org/web/20210625031227/https://edbm.mg/cadre-juridique/`,
    EDBM's own curated legislative index for investors, own text,
    verbatim, itemized by legal domain) lists, among others:
    \"1- Investissements – Loi n°2007-036 du 14 janvier 2008 sur les
    investissements à Madagascar\" (the GENERAL investment law -- this
    catalog's `:investment-legal-basis`, independently confirmed on
    EDBM's own site, not merely inferred from EDBM's self-description);
    \"2- Sociétés – Loi n°2001-026 du 03 septembre 2004 sur le contrat de
    société et la société civile – Loi n°2003-036 du 30 janvier 2004
    relative aux sociétés commerciales, modifiée et complétée par la loi
    n°2014-010 du 21 août 2014 ... Décret n°2004-453 du 06 avril 2004
    fixant les conditions d'application de la Loi n°2003-036\" (the
    NATIONAL companies law this catalog cites INSTEAD of OHADA's
    AUSCGIE, since Madagascar is not an OHADA member -- see above);
    \"3- Finances – Fiscalité Code Général des Impôts\" (independently
    corroborated on DGI's own site, see below); \"4- Droit du travail
    Loi n°2003-044 du 28 juillet 2004 portant Code du travail\" (see
    below for this catalog's honest note on a date discrepancy this
    iteration found and did not silently resolve); and, independently
    cross-confirming the ARMP finding above verbatim: \"Marchés publics
    Loi n°2016-055 du 25 janvier 2017 portant Code des marchés publics\".
    Also present but NOT modeled by this catalog (out of scope for a
    general market-entry/compliance actor): a sector-specific mining
    investment regime (\"Loi n°2001-031 du 08 octobre 2002 établissant un
    régime spécial pour les grands investissements dans le secteur
    minier malagasy, modifiée par la loi n°2005-022 du 17 octobre
    2005\"), zones et entreprises franches (Loi n°2007-037 du 14 janvier
    2008), and PPP (Loi n°2015-039 du 03 février 2016).
  - **Tax registration** is the NIF (Numéro d'Identification Fiscale),
    administered by the Direction Générale des Impôts (DGI).
    `https://www.impots.mg/` is LIVE (HTTP 200, own homepage text
    fetched directly, verbatim): \"DGI ... Direction Générale des Impôts
    ... Système d'Administration Fiscale Intégré (SAFI)\" -- DGI's own
    identity and its live integrated tax-administration system are
    directly confirmed. A 2024-07-23 Wayback snapshot of DGI's own
    document page
    (`http://web.archive.org/web/20240723202325/https://www.impots.mg/17-n-code-general-des-impots-lf-2016`,
    own title, verbatim): \"CODE GENERAL DES IMPOTS - LF 2016\" --
    confirming DGI's own governing tax code, the Code Général des Impôts
    (periodically amended by annual Lois de Finances; the specific
    edition this iteration could independently fetch this session is the
    \"LF 2016\" edition -- this iteration did NOT independently confirm
    whether a more recent Loi de Finances edition supersedes this exact
    copy, an honest gap). DGI's own site also independently lists a live
    \"NIFOnline\" e-service (URL slug `/227-nifonline`, confirmed via
    DGI's own site structure) -- corroborating that NIF issuance is a
    live, DGI-administered digital system, mirroring the discipline this
    fleet's `-moz` sibling used for NUIT/`nuit.at.gov.mz`. This iteration
    did NOT independently fetch the specific decree/article that FIRST
    established the NIF regime itself (as distinct from the Code
    Général des Impôts' ongoing administration of it) -- an honest gap,
    not filled by guessing an article number.
  - **Labour law** (grounds the `statute.facts` catalog's labour entry,
    referenced here for cross-catalog context only) -- Loi n°2003-044
    portant Code du Travail. `armp.mg`/`edbm.mg`/`impots.mg` do not host
    this law themselves; Madagascar's own `primature.gov.mg` (Prime
    Minister's Office) returned only a generic, unconfigured hosting
    test page to a direct fetch this session (own title, verbatim: \"HTTP
    Server Test Page powered by CentOS-WebPanel.com\" -- i.e. genuinely
    no content is currently deployed there, not a bot-detection block),
    and the ILO's own NATLEX legal database (the source this fleet's
    `-gin` sibling successfully used for Guinea's own Code du Travail)
    returned a genuine Cloudflare 'Just a moment' bot-detection
    challenge page to every access path tried this session (own page
    title, verbatim: \"Just a moment...\"; confirmed via response body,
    not merely inferred from a 403 status) -- per this fleet's hard
    safety rule, this iteration did NOT attempt to bypass that challenge
    in any way and instead falls back to disclosure. This iteration
    therefore used `droit-afrique.com`, a well-known but NON-official
    private Francophone-African legal-text aggregator (its own live site
    also returned a genuine, non-bot-detection Apache 403 this session,
    own body text, verbatim: \"Forbidden ... Server unable to read
    htaccess file, denying access to be safe\" -- a plain server
    misconfiguration, not a challenge page, but unreachable either way)
    via a 2015-02-13 Wayback Machine snapshot of its hosted PDF
    (`http://web.archive.org/web/20150213053104/http://www.droit-afrique.com:80/images/textes/Madagascar/Mada%20-%20Code%20du%20travail.pdf`,
    a real, machine-readable, native-text-layer PDF -- `pdftotext`
    succeeded, 2021 lines) and read its own primary text directly,
    confirming: own title page, verbatim: \"REPOBLIKAN'I MADAGASIKARA
    Tanindrazana - Fahafahana - Fandrosoana LOI N° 2003-044 Portant Code
    du Travail\" (the standard Malagasy Republic official-instrument
    letterhead/motto, consistent with a genuine government text, not
    third-party paraphrase); own Article 265 (own text, verbatim): \"La
    présente Loi abroge la Loi n° 94-029 du 25 août 1995 portant Code du
    Travail ainsi que la Loi n° 94-027 du 17 novembre 1994 portant Code
    d'Hygiène, de Sécurité et d'Environnement du Travail\" -- i.e.
    2003-044 is CONFIRMED, in its own text, as the currently-governing
    Code du Travail (the 1994/1995 predecessors are expressly revoked).
    **Honest, explicitly-flagged discrepancy this iteration found and did
    NOT silently resolve**: this PDF's own final dateline reads only
    \"Antananarivo, le 10 juin 2004.\" (with no following signature name
    captured by `pdftotext` -- possibly a scanned/image signature block,
    or an Assemblée-Nationale ADOPTION dateline rather than a
    presidential PROMULGATION dateline), whereas EDBM's own
    'Cadre juridique' page (an independent, separately-fetched official
    Malagasy source, see above) cites the SAME law as \"Loi n°2003-044 du
    28 juillet 2004 portant Code du travail\" -- a six-week-later date.
    Both dates are chronologically consistent with a normal
    adopt-then-promulgate sequence (Assemblée Nationale adoption on one
    date, Presidential promulgation/Journal-Officiel publication six
    weeks later), so this iteration treats EDBM's own citation date (28
    juillet 2004, the conventional promulgation-date citation format
    also used for the 2016-055 procurement law above) as the law's
    standard citation date, while recording the PDF's own \"10 juin 2004\"
    dateline honestly here rather than silently discarding it.

  What this catalog still does NOT claim: no independently-verified
  EDBM founding decree/law number; no independently-verified specific
  article establishing the NIF regime itself (only DGI's identity, its
  live NIFOnline system, and the Code Général des Impôts' ongoing
  administration of it are confirmed); no independently-fetched official
  Malagasy government-domain copy of the Code du Travail (only a private
  aggregator's copy, read via Wayback, whose own primary text is
  internally consistent with -- but not itself hosted on -- an official
  Malagasy domain this session); no attempt to resolve the 10-juin-2004
  vs 28-juillet-2004 Code du Travail date discrepancy beyond recording
  it. None of these is invented to make the catalog look more complete --
  the same honest-gap discipline this fleet's `-moz`/`-gin`/`-caf`
  siblings' own catalogs use.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the generic
  intake/portal-registration/filing evidence set; `:legal-basis` /
  `:owner-authority` / `:provenance` are the citation the governor
  requires before any `:jurisdiction/assess` proposal can commit.
  `:armp-ineligibility-owner-authority` / `:armp-ineligibility-legal-
  basis` / `:armp-ineligibility-provenance` ground this vertical's
  flagship governor check (`armp-ineligibility-violations` in
  `marketentry.governor`, `armp-ineligibility-satisfied?` in
  `marketentry.registry`)."
  {"MDG" {:name "Republic of Madagascar"
          :owner-authority "Autorité de Régulation des Marchés Publics (ARMP) -- an independent administrative authority (Loi n°2016-055 du 25 janvier 2017 portant Code des Marchés Publics, Article 18: 'autorité administrative indépendante dotée de pouvoirs d'administration, de décision et de sanction ... dotée de la personnalité juridique, jouit d'une autonomie administrative et financière')"
          :legal-basis "Loi n°2016-055 portant Code des Marchés Publics (promulguée à Antananarivo, le 25 janvier 2017; own Article 93 provides transitional continuity with the prior Titres VII/VIII of Loi n°2004-009 du 26 juillet 2004 pending installation of the new organs), superseding Loi n°2004-009 du 26 juillet 2004 portant Code des Marchés Publics per ARMP's own document-listing page (which labels 2016-055 '(Nouveau)') -- independently cross-confirmed by EDBM's own 'Cadre juridique' legislative index citing the identical law/date"
          :national-spec "Live national e-GP (e-Government Procurement) transactional portal at armp.mg/app.armp.mg (own meta description, verbatim: 'EGP | E-Government Procurement (e-GP) portal Madagascar') -- unlike this fleet's -moz sibling, MDG DOES have a confirmed transactional e-procurement portal domain, though its content is now a JS single-page app not exposing legal text to a static fetch"
          :provenance "https://app.armp.mg/ (live portal, confirmed reachable, title/meta only) ; http://web.archive.org/web/20211216202249/http://armp.mg/?q=les_textes_caract_re_g_n_ral (ARMP's own 'Textes fondamentaux' document-listing page, via Wayback since the live site is now SPA-only) ; http://armp.mg/sites/default/files/Loi_2016-055_CMP.pdf (Loi n°2016-055 own primary text, via the same Wayback capture, pdftotext-verified) ; http://web.archive.org/web/20210625031227/https://edbm.mg/cadre-juridique/ (EDBM's own legislative index, independent cross-confirmation of the same law/date)"
          :required-evidence ["RCS (Registre du Commerce et des Sociétés) registration record (EDBM Guichet Unique 'Création de société'/'Modification du RCS' service; Loi n°2003-036 du 30 janvier 2004 relative aux sociétés commerciales)"
                               "NIF (Numéro d'Identification Fiscale) tax record (Direction Générale des Impôts (DGI), Code Général des Impôts) -- required per Article 21(c) of the Code des Marchés Publics ('obligations fiscales ou para fiscales à la date limite fixée pour le dépôt des offres')"
                               "ARMP non-exclusion confirmation (Article 21(i)/Article 90 of the Code des Marchés Publics -- the operator not on ARMP's own quarterly-published Liste des personnes physiques et morales inéligibles à la commande publique)"
                               "EDBM investment-registration confirmation record (Agence de Promotion des Investissements (API); Loi n°2007-036 du 14 janvier 2008 sur les investissements à Madagascar), when the engagement is a private-investment project"]
          :armp-ineligibility-owner-authority "Autorité de Régulation des Marchés Publics (ARMP)"
          :armp-ineligibility-legal-basis "Loi n°2016-055, Article 90 ('Des sanctions à l'encontre du soumissionnaire ou du titulaire'), §IX-X (own text, verbatim): 'La sanction de l'inéligibilité de la commande publique ne peut dépasser cinq ans. Par contre, en cas de récidive, l'exclusion définitive peut être prononcée par l'autorité de régulation des marchés publics. L'autorité de régulation des marchés publics établit trimestriellement une liste des personnes physiques et morales inéligibles à la commande publique. Cette liste est régulièrement mise à jour, transmise aux autorités contractantes et publiée au Journal des Marchés Publics et au Journal Officiel.' Cross-referenced with Article 21(i) (own text, verbatim): candidates 'qui ont fait l'objet d'exclusion temporaire ou définitive prononcée par l'Autorité de Régulation des Marchés Publics' are not admitted to compete"
          :armp-ineligibility-provenance "http://armp.mg/sites/default/files/Loi_2016-055_CMP.pdf (Articles 21, 90, own primary text, pdftotext-verified) ; http://web.archive.org/web/20211216202249/http://armp.mg/?q=les_textes_caract_re_g_n_ral (ARMP's own document listing confirming this is the current law)"}
   ;; -- reference jurisdictions, reused verbatim from already-merged
   ;; sibling repos (cloud-itonami-iso3166-caf), not new claims --
   "USA" {:name "United States"
          :owner-authority "U.S. General Services Administration (GSA) / SAM.gov"
          :legal-basis "Federal Acquisition Regulation (FAR); System for Award Management"
          :national-spec "SAM.gov entity registration + NAICS self-certification"
          :provenance "https://sam.gov/"
          :required-evidence ["EIN record"
                               "SAM.gov registration record"
                               "State business registration record"
                               "Authorized-representative record"]}
   "DEU" {:name "Germany"
          :owner-authority "Beschaffungsamt des BMI / e-Vergabe platforms"
          :legal-basis "Gesetz gegen Wettbewerbsbeschränkungen (GWB) / VgV"
          :national-spec "e-Vergabe supplier registration under EU procurement directives"
          :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract"
                               "e-Vergabe registration record"
                               "USt-IdNr record"
                               "Authorized-representative record"]}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO spec-basis,
  and the governor must hold any proposal that tries to assess or file
  on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions actually
  have a spec-basis entry. Never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-mdg R0: " (count catalog)
                 " jurisdictions seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings) satisfy
  every evidence item listed for `iso3`? Missing spec-basis -> never
  satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn armp-ineligibility-spec-basis
  "The jurisdiction's ARMP quarterly-published ineligibility-list regime,
  or nil. For MDG this is real and current -- the flagship check this
  vertical adds is grounded here (Loi n°2016-055, Article 90 §IX-X)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:armp-ineligibility-owner-authority sb)
      (select-keys sb [:armp-ineligibility-owner-authority
                       :armp-ineligibility-legal-basis
                       :armp-ineligibility-provenance]))))
