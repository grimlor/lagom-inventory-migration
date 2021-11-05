package com.lightbend.inventory.domain;

import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.google.protobuf.Empty;
import com.lightbend.inventory.InventoryApi;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class ProductTest {

  @Test
  public void exampleTest() {
    ProductTestKit testKit = ProductTestKit.of(Product::new);
    // use the testkit to execute a command
    // of events emitted, or a final updated state:
    // ValueEntityResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
    // verify the final state after the command
    // assertEquals(expectedState, testKit.getState());
  }

  @Test
  public void getTest() {
    ProductTestKit testKit = ProductTestKit.of(Product::new);
    ValueEntityResult<InventoryApi.CurrentInventory> result = testKit.get(
            InventoryApi.GetInventory.newBuilder()
                    .setProductId("foo")
                    .build());

    InventoryApi.CurrentInventory response = result.getReply();
    assertThat(response, is(InventoryApi.CurrentInventory.newBuilder().setCount(0).build()));
  }


  @Test
  public void addTest() {
    ProductTestKit testKit = ProductTestKit.of(Product::new);
    ValueEntityResult<Empty> result = testKit.add(
            InventoryApi.AddInventory.newBuilder()
                    .setProductId("testkit-entity-id")
                    .setCount(3)
                    .build());


    var response = result.getReply();
    assertThat(response, is(Empty.getDefaultInstance()));

    var expectedState = ProductDomain.ProductState.newBuilder()
            .setProductId("testkit-entity-id")
            .setCount(3)
            .build();
    assertThat(testKit.getState(), is(expectedState));
  }

}
