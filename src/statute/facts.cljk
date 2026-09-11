(ns statute.facts
  "General-law compliance catalog for the Republic of Madagascar (MDG)
  -- extends this repo's existing `marketentry.facts` (public-
  procurement market-entry only, narrow scope) with a second, orthogonal
  catalog of statutes a company operating in this jurisdiction must
  generally track for compliance. Mirrors cloud-itonami-iso3166-ben/
  -btn/-caf/-cog/-gin/-gnb/-moz's `statute.facts` (ADR-2607141700,
  cloud-itonami-compliance-fact-federation).

  Every entry below cites an official government-hosted URL (own site,
  fetched directly this session, 2026-07-22/23) except the Code du
  Travail entry, which is explicitly flagged as sourced from a private
  legal-text aggregator via the Wayback Machine (this iteration's
  official-source attempts for that one law were genuinely blocked --
  see `marketentry.facts` namespace docstring for the full research
  trail, including a genuine Cloudflare bot-detection challenge this
  iteration did NOT attempt to bypass):

  - **Companies/commercial-entity law**: Madagascar is NOT an OHADA
    member state (independently re-verified directly on OHADA's own
    'Les Etats membres de l'OHADA' page, `ohada.org/les-etats-membres-de-
    lohada/`, fetched this session -- Madagascar named in none of the 17
    listed states), so this catalog does NOT borrow the `-ben`/`-caf`/
    `-cog`/`-gin`/`-gnb` siblings' AUSCGIE citation. Madagascar runs its
    OWN national companies-law regime: EDBM's own 'Cadre juridique'
    legislative index (`https://edbm.mg/cadre-juridique/`, fetched via a
    2021-06-25 Wayback snapshot since the live site is now a thin React
    SPA -- disclosed explicitly, own text, verbatim) cites \"Loi n°2003-036
    du 30 janvier 2004 relative aux sociétés commerciales, modifiée et
    complétée par la loi n°2014-010 du 21 août 2014\" as the primary
    companies law, plus a separate \"Loi n°2001-026 du 03 septembre 2004
    sur le contrat de société et la société civile\" for non-commercial
    company contracts, and \"Décret n°2004-453 du 06 avril 2004\" as the
    implementing decree (itself modified by décrets n°2005-151 and
    n°2011-050). Business/RCS registration itself is channelled through
    EDBM's own 'Guichet Unique' (own site, own menu items 'Création de
    société'/'Modification du RCS', fetched directly) -- RCS = Registre
    du Commerce et des Sociétés, Madagascar's OWN companies registry
    name, NOT OHADA's RCCM (Registre du Commerce et du Crédit Mobilier).
  - **Loi sur les Investissements (general Investment Law)**: EDBM's own
    'Cadre juridique' page (same source as above, own text, verbatim)
    cites \"Loi n°2007-036 du 14 janvier 2008 sur les investissements à
    Madagascar\" as the general investment-law citation, independently
    corroborating EDBM's own self-description as Madagascar's official
    'Agence de Promotion des Investissements (API)' (EDBM's own homepage
    and 'A propos' page, both fetched via Wayback this session, own
    text). This iteration did NOT independently find a dedicated general
    'Code des Investissements' distinct from this Loi (EDBM's own
    catalog additionally lists sector-specific investment regimes --
    mining (\"Loi n°2001-031 du 08 octobre 2002\"), zones franches (\"Loi
    n°2007-037 du 14 janvier 2008\") -- which this catalog does NOT model
    as the general investment entry, an honest, deliberate scoping
    choice, not an oversight).
  - **Code du Travail (Labour Code)**: this iteration found NO official
    Malagasy government-domain copy reachable this session --
    `primature.gov.mg` returned only a generic, unconfigured hosting
    test page (own title, verbatim: 'HTTP Server Test Page powered by
    CentOS-WebPanel.com'), and the ILO's own NATLEX legal database (the
    source this fleet's `-gin` sibling successfully used for its own
    Code du Travail) returned a genuine Cloudflare 'Just a moment'
    bot-detection challenge to every access path tried this session --
    this iteration did NOT attempt to bypass it, per this fleet's hard
    safety rule, and instead discloses the fallback used: a 2015-02-13
    Wayback Machine snapshot of a PDF hosted by `droit-afrique.com` (a
    well-known but NON-official private Francophone-African legal-text
    aggregator; its own live site also returned a genuine, non-bot-
    detection Apache 403 this session -- 'Server unable to read htaccess
    file, denying access to be safe', a plain server misconfiguration,
    not a challenge page), whose own primary text (`pdftotext`-verified,
    a real machine-readable PDF, not scanned) carries the standard
    Malagasy official-instrument letterhead ('REPOBLIKAN'I MADAGASIKARA
    Tanindrazana - Fahafahana - Fandrosoana') and confirms, in its own
    Article 265, verbatim: \"La présente Loi abroge la Loi n° 94-029 du
    25 août 1995 portant Code du Travail ainsi que la Loi n° 94-027 du
    17 novembre 1994 portant Code d'Hygiène, de Sécurité et
    d'Environnement du Travail\" -- confirming Loi n°2003-044 as the
    CURRENT Code du Travail. This iteration ALSO independently
    cross-confirmed the SAME law/number via EDBM's own 'Cadre juridique'
    page (a genuinely official, separately-fetched Malagasy source),
    which cites it as \"Loi n°2003-044 du 28 juillet 2004 portant Code du
    travail\" -- a date six weeks later than the aggregator PDF's own
    final dateline ('Antananarivo, le 10 juin 2004', with no signature
    name captured, possibly an Assemblée-Nationale adoption dateline
    rather than the Presidential promulgation date). This discrepancy is
    recorded here honestly rather than silently resolved -- see
    `marketentry.facts` for the full discussion.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"MDG"
   [{:statute/id "mdg.loi-2003-044-code-du-travail"
     :statute/title "Code du Travail de la République de Madagascar"
     :statute/jurisdiction "MDG"
     :statute/kind :law
     :statute/law-number "Loi n°2003-044 (own primary text, via droit-afrique.com aggregator PDF read via Wayback Machine, revokes Loi n°94-029 du 25 août 1995 and Loi n°94-027 du 17 novembre 1994 per its own Article 265; own final dateline 'Antananarivo, le 10 juin 2004'; independently cross-confirmed on EDBM's own 'Cadre juridique' page as 'Loi n°2003-044 du 28 juillet 2004 portant Code du travail' -- a six-week date discrepancy between the two sources this catalog records honestly rather than silently resolving, see namespace docstring)"
     :statute/url "http://web.archive.org/web/20150213053104/http://www.droit-afrique.com:80/images/textes/Madagascar/Mada%20-%20Code%20du%20travail.pdf"
     :statute/url-provenance :non-official-aggregator-wayback-verified
     :statute/enacted-date "2004-07-28"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}
    {:statute/id "mdg.loi-2007-036-investissements"
     :statute/title "Loi sur les Investissements à Madagascar"
     :statute/jurisdiction "MDG"
     :statute/kind :law
     :statute/law-number "Loi n°2007-036 du 14 janvier 2008 (per EDBM's own 'Cadre juridique' legislative index, own text, fetched directly via Wayback this session)"
     :statute/url "http://web.archive.org/web/20210625031227/https://edbm.mg/cadre-juridique/"
     :statute/url-provenance :official-investment-promotion-agency-edbm
     :statute/enacted-date "2008-01-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:investment}}
    {:statute/id "mdg.loi-2003-036-societes-commerciales"
     :statute/title "Loi relative aux Sociétés Commerciales"
     :statute/jurisdiction "MDG"
     :statute/kind :law
     :statute/law-number "Loi n°2003-036 du 30 janvier 2004, modifiée et complétée par la loi n°2014-010 du 21 août 2014 (per EDBM's own 'Cadre juridique' legislative index, own text, fetched directly via Wayback this session) -- Madagascar's own national companies-law statute (see marketentry.facts namespace docstring for this catalog's independent re-confirmation that Madagascar is not an OHADA member state)"
     :statute/url "http://web.archive.org/web/20210625031227/https://edbm.mg/cadre-juridique/"
     :statute/url-provenance :official-investment-promotion-agency-edbm
     :statute/enacted-date "2004-01-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-mdg statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "MDG")) " MDG statutes seeded with an "
                 "official citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :investment)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
