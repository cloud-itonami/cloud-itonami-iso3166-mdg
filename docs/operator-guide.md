# Operator guide — MDG (Republic of Madagascar)

## Regulatory grounding

- **Legal basis**: Loi n°2016-055 portant Code des Marchés Publics,
  promulguée à Antananarivo, le 25 janvier 2017 (superseding Loi
  n°2004-009 du 26 juillet 2004). Own primary text read via
  `pdftotext`; independently cross-confirmed by EDBM's own legislative
  index.
- **Procurement regulator**: Autorité de Régulation des Marchés
  Publics (ARMP) — an independent administrative authority (Article
  18). Live national e-GP transactional portal: `https://app.armp.mg/`.
- **Article 21 exclusions/incapacities**: candidates who have not
  fulfilled their fiscal/para-fiscal obligations by the bid deadline
  (item c), or who are subject to a temporary or definitive exclusion
  pronounced by ARMP (item i), are not admitted to compete.
- **ARMP ineligibility list (this vertical's flagship mechanism)**:
  Article 90 §IX-X — ARMP publishes, QUARTERLY, a "Liste des personnes
  physiques et morales inéligibles à la commande publique" (Journal des
  Marchés Publics + Journal Officiel). Ordinary ("temporaire")
  ineligibility may not exceed 5 years; only a formal ARMP récidive
  finding can make an exclusion définitive (permanent).

## Business registration / licensing

- **EDBM (Economic Development Board of Madagascar)** — Madagascar's
  own Guichet Unique (one-stop-shop), offering "Création de société"
  and "Modification du RCS" (Registre du Commerce et des Sociétés,
  Madagascar's own companies registry — NOT OHADA's RCCM; Madagascar is
  independently confirmed NOT an OHADA member). `https://www.edbm.mg/`
- **Companies law**: Loi n°2003-036 du 30 janvier 2004 relative aux
  sociétés commerciales (modifiée et complétée par la loi n°2014-010 du
  21 août 2014).
- **NIF (Numéro d'Identification Fiscale)** — administered by the
  Direction Générale des Impôts (DGI), under the Code Général des
  Impôts. `https://www.impots.mg/` ; live e-services: SAFI (Système
  d'Administration Fiscale Intégré), NIFOnline.
- **EDBM (Agence de Promotion des Investissements)** — administers
  investment facilitation under Loi n°2007-036 du 14 janvier 2008 sur
  les investissements à Madagascar. No specific EDBM founding decree/
  law number was independently confirmed this session — this actor
  tracks only what IS confirmed (RCS, NIF, ARMP ineligibility clearance,
  EDBM investment registration) as required evidence.

## Using the actor

1. `:engagement/intake` — record/patch an engagement (operator name,
   fee terms, jurisdiction). Auto-commits when clean at phase 3.
2. `:jurisdiction/assess` — the actor proposes the MDG required-
   evidence checklist above, citing the Code des Marchés Publics/ARMP
   source. ALWAYS requires human approval, even when clean.
3. `:filing/draft` — the actor proposes drafting a filing package.
   ALWAYS requires human approval; HELD if evidence is incomplete or
   the engagement was already drafted.
4. `:filing/submit` — the actor proposes submitting the filing.
   ALWAYS requires human approval; HARD-HELD (unoverridable) if:
   - the engagement requires ARMP clearance and the operator IS
     currently on ARMP's own quarterly ineligibility list
     (`:on-armp-ineligibility-list? true`);
   - the engagement requires ARMP clearance and a recorded prior
     exclusion duration exceeds the Article 90 §IX 5-year statutory cap
     with no récidive finding on record
     (`:armp-prior-exclusion-duration-years` > 5 and
     `:armp-recidivism-finding? false`);
   - the claimed engagement fee doesn't equal
     `base-fee + monthly-rate × monitoring-months`;
   - the engagement was already submitted.

## Demo engagements

`src/marketentry/store.cljk`'s `demo-data` seeds five engagements:

| id     | scenario                                                                     |
|--------|-------------------------------------------------------------------------------|
| eng-1  | clean — commits end-to-end                                                    |
| eng-2  | currently on ARMP's own ineligibility list — HARD hold                        |
| eng-3  | not currently listed, but a 7-year prior exclusion with no récidive finding — HARD hold |
| eng-4  | claimed fee doesn't match recomputed fee — HARD hold                          |
| eng-5  | doesn't itself require ARMP clearance (pure private-investment engagement) — commits |
