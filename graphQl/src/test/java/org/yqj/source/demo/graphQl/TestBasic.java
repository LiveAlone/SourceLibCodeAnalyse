package org.yqj.source.demo.graphQl;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLType;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yaoqijun.
 * Date:2016-02-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */

@Slf4j
public class TestBasic {

    private GraphQL graphQL;

    @Before
    public void init() {
        Pair<String, RuntimeWiring> pair = buildGraphQl();
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(pair.getLeft());

        RuntimeWiring runtimeWiring = pair.getRight();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Test
    public void TestDemo() {
        ExecutionResult executionResult = graphQL.execute("{hello}");
        System.out.println(executionResult.getData().toString());
    }

    @Test
    public void TestSchema() {
        String schema = "type Foo { bar: String }";
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        log.info("foo type definition :{}", typeDefinitionRegistry.getType("Foo").orElse(null));
    }

    public static Pair<String, RuntimeWiring> buildGraphQl() {

        String schema = "type Query{hello: String}";

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        return Pair.of(schema, runtimeWiring);
    }
}
