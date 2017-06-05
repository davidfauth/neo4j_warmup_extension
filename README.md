Warmup
===========

Warmup Neo4j by touching all nodes / relationships / properties.


1. Build it:

        mvn clean package

2. Copy target/warmup-1.0.jar to the plugins/ directory of your Neo4j server.

3. Configure Neo4j by adding a line to conf/neo4j.conf:

		dbms.unmanaged_extension_classes=com.neo4j.warmup=/v1

4. Start Neo4j server.

5. Check that it is installed correctly over HTTP:

		:GET /v1/service/helloworld

6. Warm up the database:

		:GET /v1/service/warmupAll
		:GET /v1/service/warmupNodes
		:GET /v1/service/warmupRelationships




       

