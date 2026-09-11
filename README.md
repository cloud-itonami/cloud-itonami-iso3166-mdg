# cloud-itonami-iso3166-mdg

**MDG**: Republic of Madagascar.

- ARMP (Autorité de Régulation des Marchés Publics) public-procurement
  compliance -- Loi n°2016-055 du 25 janvier 2017 portant Code des
  Marchés Publics
- ARMP's own quarterly-published Liste des personnes physiques et
  morales inéligibles à la commande publique (Article 90 §IX-X) --
  this vertical's flagship governor check
- EDBM (Economic Development Board of Madagascar) Guichet Unique
  business registration/RCS + DGI (Direction Générale des Impôts) NIF +
  EDBM Agence de Promotion des Investissements

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture as
`cloud-itonami-iso3166-moz` (Mozambique -- the closest architectural
match: another catalog whose jurisdiction is NOT an OHADA member state)
and `cloud-itonami-iso3166-gin`/`cloud-itonami-iso3166-caf` (fellow
Francophone African market-entry catalogs, though both of THOSE are
OHADA members, unlike Madagascar):

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites ARMP's own
  government site (`armp.mg`/`app.armp.mg`) and the actual Loi
  n°2016-055 Code des Marchés Publics PDF for the current procurement
  code, EDBM's own site (`edbm.mg`) for business registration/RCS and
  general investment law, and the Direction Générale des Impôts' own
  site (`impots.mg`) for NIF/Code Général des Impôts. `governor.cljc`'s
  flagship check (`armp-ineligibility-violations`) independently
  verifies the operator is not CURRENTLY on ARMP's own quarterly-
  published ineligibility list AND that any recorded prior exclusion
  duration does not exceed the Code des Marchés Publics' own 5-year
  statutory cap (Article 90 §IX) absent an ARMP récidive finding -- a
  genuine two-condition, time-bounded test grounded directly in Article
  90's own text.
- `src/statute/facts.cljk` -- general-law catalog: Loi n°2003-044
  portant Code du Travail, Loi n°2007-036 du 14 janvier 2008 sur les
  investissements à Madagascar, and Loi n°2003-036 du 30 janvier 2004
  relative aux sociétés commerciales. **Madagascar is NOT an OHADA
  member state** (independently re-verified directly on OHADA's own
  member-states page this session -- not assumed from the `-ben`/`-caf`/
  `-cog`/`-gin`/`-gnb` siblings' own OHADA membership, the exact house
  mistake this fleet has made before for other Francophone African
  nations), so this catalog does NOT borrow their AUSCGIE (companies)
  or AUDCG (RCCM) citations -- Madagascar runs its own national
  companies-law regime and its own registry name (RCS, not RCCM).

Every citation is curl/pdftotext-verified against an official source
(`armp.mg`, `edbm.mg`, `impots.mg`, `ohada.org`) or, where the live site
is now a thin JS single-page app exposing no server-rendered legal text
(`armp.mg`/`app.armp.mg`, `edbm.mg`), a Wayback Machine snapshot of that
SAME official site's own earlier, server-rendered content (not a
third-party paraphrase). The Code du Travail entry is the one exception
to "official source" -- Madagascar's own `primature.gov.mg` returned
only a generic unconfigured hosting page and the ILO's own NATLEX
database returned a genuine Cloudflare bot-detection challenge this
iteration did NOT attempt to bypass, so that one citation is sourced
from a private Francophone-African legal-text aggregator via the
Wayback Machine and explicitly flagged as such -- see
`src/marketentry/facts.cljk`'s namespace docstring for the full research
trail, including facts this iteration could NOT verify (EDBM's own
founding decree/law number; the specific article establishing the NIF
regime itself; an unresolved six-week date discrepancy between two
independent sources' own citation of the Code du Travail's promulgation
date) and honestly left out or flagged rather than invented.

```
kbb -M:dev:test
```

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Madagascar:

- `src/culture/facts.cljk` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
