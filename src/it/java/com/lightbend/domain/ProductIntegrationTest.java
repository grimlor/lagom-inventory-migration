package com.lightbend.domain;

import com.akkaserverless.javasdk.testkit.junit.AkkaServerlessTestKitResource;
import com.google.protobuf.Empty;
import com.lightbend.Inventory;
import com.lightbend.InventoryApi;
import com.lightbend.InventoryService;
import org.junit.ClassRule;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

// Example of an integration test calling our service via the Akka Serverless proxy
// Run all test classes ending with "IntegrationTest" using `mvn verify -Pit`
public class ProductIntegrationTest {

    /**
     * The test kit starts both the service container and the Akka Serverless proxy.
     */
    @ClassRule
    public static final AkkaServerlessTestKitResource testKit =
            new AkkaServerlessTestKitResource(Inventory.createAkkaServerless());

    /**
     * Use the generated gRPC client to call the service through the Akka Serverless proxy.
     */
    private final InventoryService client;

    public ProductIntegrationTest() {
        client = testKit.getGrpcClient(InventoryService.class);
    }

    @Test
    public void getOnNonExistingEntity() throws Exception {
        InventoryApi.CurrentInventory result =
                client.get(InventoryApi.GetInventory.newBuilder().setProductId("foo").build())
                        .toCompletableFuture().get(5, SECONDS);

        assertThat(result, is(InventoryApi.CurrentInventory.newBuilder().setCount(0).build()));
    }

    @Test
    public void addOnNonExistingEntity() throws Exception {
        client.add(InventoryApi.AddInventory.newBuilder()
                        .setProductId("bar")
                        .setCount(3)
                        .build())
                .toCompletableFuture().get(5, SECONDS);

        InventoryApi.CurrentInventory result =
                client.get(InventoryApi.GetInventory.newBuilder().setProductId("bar").build())
                        .toCompletableFuture().get(5, SECONDS);

        assertThat(result, is(InventoryApi.CurrentInventory.newBuilder().setCount(3).build()));
    }
}
