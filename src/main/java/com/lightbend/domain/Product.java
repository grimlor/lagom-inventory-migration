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
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state");
  }

  @Override
  public Effect<InventoryApi.CurrentInventory> get(ProductDomain.ProductState currentState, InventoryApi.GetInventory getInventory) {
    return effects().error("The command handler for `Get` is not implemented, yet");
  }

  @Override
  public Effect<Empty> add(ProductDomain.ProductState currentState, InventoryApi.AddInventory addInventory) {
    return effects().error("The command handler for `Add` is not implemented, yet");
  }
}
