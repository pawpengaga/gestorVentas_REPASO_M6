# Repaso de JDBC para SpringBoot

Aplicacion de gestión de punto de venta con Usuarios y Detalle

## Novedades
- Pool de conexiones
- Archivo `schema.sql` para crear las tablas **desde la app**
- Registro de logs por medio de `logback.xml`
- Uso de `seeds` por medio de `data.sql`

## Explicaciones

- SCHEMA crea la estructura de las tablas
- DATA crea los primeros registros

## Curiosidades

Las cosas que nos ahorra `@Autowired`

```java

// Crea el objeto `JdbcTemplate` como constante...
private final JdbcTemplate jdbc;

// Asignarlo al constructor de manera manual...
public SaleRepository(JdbcTemplate jdbc){
  this.jdbc = jdbc;
}

```


> Proyecto extraño pero muy interesante