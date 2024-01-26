# Inventory-Products-Elasticsearch
Ejemplo de aplicación de Inventario usando Elasticsearch

## Documentación Útil
- Documentación oficial de [Spring Data Elasticsearch 4.2.3](https://docs.spring.io/spring-data/elasticsearch/docs/4.2.3/reference/html/#new-features)
- Documentación oficial de [Elasticsearch 7.10](https://www.elastic.co/guide/en/elasticsearch/reference/7.10/index.html)

Recuerda que para cargar los datos de prueba debes ejecutar el siguiente comando (desde la carpeta raíz del proyecto):
```bash
curl -XPUT '<<Full Access URL de Bonsai>>/_bulk' --data-binary @Products_raw.json -H 'Content-Type: application/json'
```
