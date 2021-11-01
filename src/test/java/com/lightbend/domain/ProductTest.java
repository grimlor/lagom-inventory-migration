package com.lightbend.domain;

import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.google.protobuf.Empty;
import com.lightbend.InventoryApi;
import org.junit.Test;

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
    // ValueEntityResult<CurrentInventory> result = testKit.get(GetInventory.newBuilder()...build());
  }


  @Test
  public void addTest() {
    ProductTestKit testKit = ProductTestKit.of(Product::new);
    // ValueEntityResult<Empty> result = testKit.add(AddInventory.newBuilder()...build());
  }

}
