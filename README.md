spring-hibernate4-multitenant
=============================

Example of multitenant usage - hibernate 4 &amp; spring 3


What it can do for you
================

Multitenant support offer to have multiple DBs or Schemas for "tenants". It is transparent from application point of view.

Options
====

- hibernate.multiTenancy
 - DATABASE
 - SCHEMA
 - DISCRIMINATOR - it is planned for Hibernate 5

These two classes must be implemented by you
======

- hibernate.tenant\_identifier\_resolver - it must return tenant id for current thread. Typically from request header?

- hibernate.multi\_tenant\_connection\_provider - it must return connection for given tenant indentifier (result of hibernate.tenant\_identifier_resolver)

Quite interesting parts in code
====

- sessionFactory
 - hibernateProperties
 - - it can be set using map, so you can set bean for some hibernate properties (e.g. hibernate.tenant\_identifier\_resolver)
 - - _hibernate.hbm2ddl.auto_ cannot be used or it will fail

- webSessionTenantIdentifierResolver
 - there is scope set to _request_ so every http request to server will create new instance of this class but
 - you have to use 
```
<aop:scoped-proxy/>
```
to let spring create a proxy around this bean in order to provide new instance every time
 - for _request_ scoped bean you can use
```
@Autowired
private HttpServletRequest request;
```
