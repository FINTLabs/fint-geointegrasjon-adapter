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

###

Supported provider endpoints

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
