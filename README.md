# FINT _GeoIntegrasjon_ Adapter
This adapter integrates with [GeoUntegrasjon Arkiv](https://geointegrasjon.no/arkiv/).

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
| `fint.geointegrasjon.service-url` | `https://test.svarut.ks.no/tjenester/forsendelseservice/ForsendelsesServiceV11` | |
| `fint.geointegrasjon.username`|  | |
| `fint.geointegrasjon.password` |  | |
| `fint.geointegrasjon.connection-timeout` | `120000` | |
| `fint.geointegrasjon.receive-timeout` | `120000` | |
| `fint.geointegrasjon.organisation.number` |  | |
| `fint.geointegrasjon.organisation.name` |  | |
| `fint.geointegrasjon.organisation.adresse1` |  | |
| `fint.geointegrasjon.organisation.adresse2` | '' | |
| `fint.geointegrasjon.organisation.adresse3` | '' | |
| `fint.geointegrasjon.organisation.postalcode` |  | |
| `fint.geointegrasjon.organisation.city` |  | |
| `fint.geointegrasjon.leveringsmetode` | `KUN_DIGITAL_UTEN_LEVERANSEGARANTI_MASSEUTSENDELSE` | |


## More information on configuration
- **[SSE Configuration](https://github.com/FINTLabs/fint-sse#sse-configuration)**
- **[OAuth Configuration](https://github.com/FINTLabs/fint-sse#oauth-configuration)** 
