# FINT _GeoIntegrasjon_ Adapter
This adapter integrates with [GeoIntegrasjon Arkiv](https://geointegrasjon.no/arkiv/).

## Adapter configuration
| Key | Description | Default |
|-----|-------------|---------|
| `fint.adapter.organizations` | List of orgIds the adapter handles. |  |
| `fint.adapter.endpoints.provider.sse` | Url to the sse endpoint for provider | `/sse/%s` |
| `fint.adapter.endpoints.provider.status` | Url to the status endpoint for provider | `/status` |
| `fint.adapter.endpoints.provider.response` | Url to the response endpoint for provider | `/response` |
| `fint.adapter.endpoints.provider.providers.arkiv` | Baseurl for the arkiv provider |  |
| `fint.adapter.endpoints.provider.providers.kulturminne` | Baseurl for the kulturminne provider |  |
| `fint.adapter.organizations` |  | |
| `fint.adapter.sse-expiration` | `1200000` | |
| `fint.internal-files.directory` | `file-cache` | |
| `fint.internal-files.connection-string` | Azure connection string to storage account | |
| `fint.internal-files.type` | `BLOB` or `FILE`. `BLOB` will store files in Azure while `FILE` will store files in the container | |
| `fint.geointegrasjon.service-url` | Root URL for the GeoIntegrasjon SOAP endpoint | |
| `fint.geointegrasjon.innsyn` | Path to the Innsyn service endpoint | `/ArkivInnsynService.svc/ArkivInnsynService` |
| `fint.geointegrasjon.oppdatering` | Path to the Oppdatering service endpoint | `/ArkivOppdateringService.svc/ArkivOppdateringService` |
| `fint.geointegrasjon.username`| Service username | |
| `fint.geointegrasjon.password` | Service password | |
| `fint.geointegrasjon.use-wss` | Use WS-Security instead of Basic Auth | `false` |
| `fint.geointegrasjon.tracing` | Log trace of SOAP requests and responses | `false` |
| `fint.geointegrasjon.fagsystem` | System name for external key (EksternNoekkel) | |
| `fint.geointegrasjon.tilleggstype` | Name of Tilleggsinformasjon attribute used for custom fields | |
| `fint.case.defaults.*` | Defaults for various case types | |
| `fint.case.format.*` | Formats for titles and custom fields for various case types | |

## More information on configuration
- **[`fint.case.*` attributes](/FINTLabs/fint-arkiv-case-defaults/)**
- **[SSE Configuration](/FINTLabs/fint-sse#sse-configuration)**
- **[OAuth Configuration](/FINTLabs/fint-sse#oauth-configuration)** 
