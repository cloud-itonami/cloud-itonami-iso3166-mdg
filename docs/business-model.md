# Business model — MDG (Republic of Madagascar)

Independent public-sector market-entry and procurement-compliance
service for Madagascar, run by a supervised MarketEntry-LLM advisor
sealed behind an independent **Market-Entry Compliance Governor** —
the same actor family as `cloud-itonami-iso3166-moz` (Mozambique, the
closest architectural match: another jurisdiction that is NOT an OHADA
member state) and `cloud-itonami-iso3166-gin`/`cloud-itonami-iso3166-caf`.

## Grounding

This iteration's research (2026-07-22/23) confirmed the following
directly, by curl/pdftotext-fetching and reading each primary source
itself this session:

- **Madagascar is NOT an OHADA member state** — independently
  re-verified directly against OHADA's own "Les Etats membres de
  l'OHADA" page (`ohada.org/les-etats-membres-de-lohada/`), own text,
  listing 17 member states none of which is Madagascar. This fleet has
  gotten this exact kind of assumption wrong before for other
  Francophone African nations (assuming OHADA membership, or a
  regulator's acronym, by analogy instead of checking); this catalog
  does not repeat that mistake.
- **Procurement legal basis**: Loi n°2016-055 portant Code des Marchés
  Publics, promulguée à Antananarivo le 25 janvier 2017 — confirmed
  both from ARMP's own document-listing page (which labels it "Nouveau",
  i.e. current, superseding Loi n°2004-009 du 26 juillet 2004) AND by
  downloading and reading the law's own primary text directly (a real,
  machine-readable PDF, `pdftotext`-verified). Independently
  cross-confirmed by a SECOND official Malagasy source, EDBM's own
  "Cadre juridique" legislative index, citing the identical law and
  date.
- **Procurement regulator**: Autorité de Régulation des Marchés Publics
  (ARMP) — an independent administrative authority per the law's own
  Article 18 ("autorité administrative indépendante dotée de pouvoirs
  d'administration, de décision et de sanction"). ARMP also operates a
  real, live national e-GP (e-Government Procurement) transactional
  portal (`app.armp.mg`) — unlike this fleet's `-moz` sibling, which
  found no such transactional portal for Mozambique.
- **Flagship mechanism — ARMP's own quarterly-published ineligibility
  list**: Article 90 §IX-X of the Code des Marchés Publics establishes
  that ordinary ("temporaire") ineligibility from public procurement may
  not exceed 5 years, UNLESS ARMP makes a formal récidive (repeat-
  offense) finding, in which case exclusion définitive (permanent) is
  lawful — and ARMP must publish an updated ineligibility list
  quarterly (Journal des Marchés Publics + Journal Officiel). This is a
  genuinely different mechanism shape from this fleet's other flagship
  checks documented in sibling catalogs (a plain two-registry boolean,
  or a percentage-of-value pecuniary-sanction range): a time-bounded
  exclusion with a statutory cap and a named escape hatch.
- **Business registration**: EDBM (Economic Development Board of
  Madagascar) is Madagascar's own Guichet Unique (one-stop-shop),
  confirmed directly on EDBM's own site — its own "GUICHET UNIQUE" menu
  offers both "Création de société" (company creation) and
  "Modification du RCS" (companies-registry maintenance). RCS
  (Registre du Commerce et des Sociétés) is Madagascar's OWN companies
  registry name, distinct from OHADA's RCCM.
- **Companies law**: Loi n°2003-036 du 30 janvier 2004 relative aux
  sociétés commerciales (modifiée et complétée par la loi n°2014-010 du
  21 août 2014) — Madagascar's own national companies-law statute,
  confirmed on EDBM's own legislative index, NOT an OHADA Acte
  Uniforme.
- **Tax registration**: NIF (Numéro d'Identification Fiscale),
  administered by the Direction Générale des Impôts (DGI) — this
  iteration confirmed DGI's own identity, its live "Système
  d'Administration Fiscale Intégré (SAFI)" and "NIFOnline" e-services,
  and the Code Général des Impôts (own document, "LF 2016" edition
  confirmed reachable), but did NOT independently confirm the specific
  article that first established the NIF regime itself (an honest gap).
- **Private investment**: Loi n°2007-036 du 14 janvier 2008 sur les
  investissements à Madagascar — the general investment law, confirmed
  directly on EDBM's own legislative index. EDBM self-describes as
  Madagascar's official "Agence de Promotion des Investissements
  (API)".
- Did **NOT** find EDBM's own founding decree/law number this session
  (an honest gap).
- Did **NOT** find an official Malagasy government-domain copy of the
  Code du Travail — `primature.gov.mg` returned only a generic
  unconfigured hosting page, and the ILO's own NATLEX database returned
  a genuine Cloudflare bot-detection challenge this iteration did NOT
  attempt to bypass. This one citation is instead sourced from a
  private Francophone-African legal-text aggregator (`droit-afrique.com`)
  via a Wayback Machine snapshot of its hosted PDF, whose own primary
  text (Malagasy Republic letterhead, own Article 265 abrogation clause)
  confirms Loi n°2003-044 as the current Code du Travail — but this
  iteration found an unresolved SIX-WEEK discrepancy between that PDF's
  own final dateline ("10 juin 2004") and EDBM's own citation ("28
  juillet 2004") that is recorded honestly rather than silently
  resolved.

See `src/marketentry/facts.cljk` and `src/statute/facts.cljk` for the
full catalog entries and their docstrings, which are the single source
of truth for every regulatory claim this actor makes.

## Service

A market-entry operator engages this actor to:

1. **Intake** an engagement (company/operator details).
2. **Assess** the jurisdiction — the actor cites the exact spec-basis
   above and returns the required-evidence checklist. A jurisdiction
   with no catalog entry gets NO fabricated checklist (HARD hold).
3. **Draft** a filing package once evidence is complete (always
   human-approved).
4. **Submit** the filing once ARMP-ineligibility clearance (not
   currently listed, and any recorded prior exclusion within the
   Article 90 §IX statutory cap or backed by a récidive finding) and the
   independently-recomputed engagement fee both check out (always
   human-approved, always HARD-held if either is wrong).

## Engagement fee

Base fee + monthly monitoring rate × monitoring months. The Governor
independently recomputes this on every `:filing/submit` and HARD-holds
on any mismatch with the claimed fee — never trusts the LLM's own
arithmetic.

## Trust Controls

- Any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off — no phase, however mature, allows
  `:filing/draft`/`:filing/submit` to auto-commit.
- A false or fabricated regulatory-requirement claim is a HARD hold —
  the Governor's `spec-basis` check rejects any proposal that doesn't
  cite `marketentry.facts`.
- Currently being on ARMP's own quarterly-published ineligibility list,
  OR a recorded prior exclusion whose duration exceeds the Code des
  Marchés Publics' own Article 90 §IX 5-year statutory cap without an
  ARMP récidive finding, on an engagement that requires ARMP clearance,
  is a HARD hold, unoverridable by a human approver.
- A mismatched engagement fee is a HARD hold, unoverridable by a
  human approver.
- Double-drafting or double-submitting the same engagement is a HARD
  hold.

## Precedent

This actor follows the same architecture as `cloud-itonami-iso3166-moz`
and `cloud-itonami-iso3166-gin`/`-caf`, and ships SIX governor checks
(not a richer sibling's seven), because the dossier does not ground a
distinct NIF-establishing-article check separate from ordinary Article
21(c)/Article 90 ARMP exclusion screening.
