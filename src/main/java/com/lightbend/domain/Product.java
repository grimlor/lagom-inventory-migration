package com.lightbend.domain;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.google.protobuf.Empty;
import com.lightbend.InventoryApi;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A value entity. */
public class Product extends AbstractProduct {
  @SuppressWarnings("unused")
  private final String entityId;

  public Product(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public ProductDomain.ProductState emptyState() {
    return ProductDomain.ProductState.newBuilder()
            .setProductId(this.entityId)
            .setCount(0)
            .build();
  }

  @Override
  public Effect<InventoryApi.CurrentInventory> get(ProductDomain.ProductState currentState, InventoryApi.GetInventory getInventory) {
    return effects().reply(
            InventoryApi.CurrentInventory.newBuilder()
                    .setCount(currentState.getCount())
                    .build());
  }

  @Override
  public Effect<Empty> add(ProductDomain.ProductState currentState, InventoryApi.AddInventory addInventory) {
    var newState = currentState.toBuilder()
            .setCount(currentState.getCount() + addInventory.getCount())
            .build();
    return effects().updateState(newState).thenReply(Empty.getDefaultInstance());
  }
}
