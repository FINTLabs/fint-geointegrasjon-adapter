# FINT _GeoIntegrasjon_ Adapter

This adapter integrates with [GeoIntegrasjon Arkiv](https://geointegrasjon.no/arkiv/).

## Adapter configuration

| Key                                     | Description                                                                | Default                                                |
|-----------------------------------------|----------------------------------------------------------------------------|--------------------------------------------------------|
| `fint.adapter.organizations`            | List of orgIds the adapter handles.                                        |                                                        |
| `fint.adapter.endpoints.sse`            | Url to the sse endpoint for provider                                       | `/sse/%s`                                              |
| `fint.adapter.endpoints.status`         | Url to the status endpoint for provider                                    | `/status`                                              |
| `fint.adapter.endpoints.response`       | Url to the response endpoint for provider                                  | `/response`                                            |
| `fint.adapter.endpoints.providers.*`    | Baseurl for the `*` provider (see below)                                   |                                                        |
| `fint.adapter.sse-expiration`           | Expiration for SSE messages                                                | `1200000`                                              |                                                        
| `fint.internal-files.directory`         | Location for `FILE` based internal files                                   | `file-cache`                                           |                                                        
| `fint.internal-files.connection-string` | Azure connection string to storage account for `BLOB` based internal files |                                                        |
| `fint.internal-files.type`              | Location for internal files, `BLOB` or `FILE`.                             |                                                        |
| `fint.geointegrasjon.service-url`       | Root URL for the GeoIntegrasjon SOAP endpoint                              |                                                        |
| `fint.geointegrasjon.innsyn`            | Path to the Innsyn service endpoint                                        | `/ArkivInnsynService.svc/ArkivInnsynService`           |
| `fint.geointegrasjon.oppdatering`       | Path to the Oppdatering service endpoint                                   | `/ArkivOppdateringService.svc/ArkivOppdateringService` |
| `fint.geointegrasjon.username`          | Service username                                                           |                                                        |
| `fint.geointegrasjon.password`          | Service password                                                           |                                                        |
| `fint.geointegrasjon.use-wss`           | Use WS-Security instead of Basic Auth                                      | `false`                                                |
| `fint.geointegrasjon.apikey`            | Use API key (passed as a HTTP header) instead of Basic Auth or WS-Security |                                                        |
| `fint.geointegrasjon.tracing`           | Log trace of SOAP requests and responses                                   | `false`                                                |
| `fint.geointegrasjon.fagsystem`         | System name for external key (EksternNoekkel)                              |                                                        |
| `fint.geointegrasjon.tilleggstype`      | Name of Tilleggsinformasjon attribute used for custom fields               |                                                        |
| `fint.case.defaults.*`                  | Defaults for various case types                                            |                                                        |
| `fint.case.format.*`                    | Formats for titles and custom fields for various case types                |                                                        |

### Supported provider endpoints

- `kodeverk`
- `noark`
- `kulturminne`
- `samferdsel`

## More information on configuration

- **[`fint.case.*` attributes](https://github.com/FINTLabs/fint-arkiv-case-defaults#fint-arkiv-case-defaults)**
- **[SSE Configuration](https://github.com/FINTLabs/fint-sse#sse-configuration)**
- **[OAuth Configuration](https://github.com/FINTLabs/fint-sse#oauth-configuration)** 

## Developer guide

https://geointegrasjon.no/arkiv/veileder-arkiv/veileder-arkiv-for-leverandor-av-klientsystem/veileder-for-gi-arkiv-integrasjon/

# OData filter support

This adapter have support for OData filtering of cases. That means it's now possible to
get cases based on a OData filter, not only `mappeid`, `systemid` and `soknadsnummer`.

We currently support `arkivdel`, primary `klassifikasjon`, `saksdato`, `saksmappetype`, `saksstatus`, `tittel` and
`offentligtittel`.

NB! Be aware of that journalposts are NOT included and returned with the cases when using this OData filter feature.

### Examples
- `$filter=arkivdel eq 'SAK'`
- `$filter=klassifikasjon/primar/verdi eq '123456789'`
- `$filter=saksdato eq '1999-12-31'`
- `$filter=saksmappetype eq 'OPL'`
- `$filter=saksstatus eq 'B'`
- `$filter=tittel eq 'En ganske unik sakstittel'`

# Shielded titles

Parts of titles can be shielded. To shield content, use `@...@`. It is only possible to shield the last part of the title.

### Examples

* Title: `Opplæringsmappe Kari Nordmann 01.01.1970`
* Public title: `Opplæringsmappe @Kari Nordmann 01.01.1970@`

### Result

Everything between the two `@` will be shielded, resulting in an `offentligTittel` in ACOS WebSak `Opplæringsmappe` and
the field `skjermetTittel` set to `true`.