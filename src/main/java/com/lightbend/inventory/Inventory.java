package com.lightbend.inventory;

import com.akkaserverless.javasdk.AkkaServerless;
import com.lightbend.inventory.domain.Product;
import com.lightbend.inventory.view.FullInventoryView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public final class Inventory {

  private static final Logger LOG = LoggerFactory.getLogger(Inventory.class);

  public static AkkaServerless createAkkaServerless() {
    // The AkkaServerlessFactory automatically registers any generated Actions, Views or Entities,
    // and is kept up-to-date with any changes in your protobuf definitions.
    // If you prefer, you may remove this and manually register these components in a
    // `new AkkaServerless()` instance.
    return AkkaServerlessFactory.withComponents(
            Product::new,
            FullInventoryView::new);
  }

  public static void main(String[] args) {
    LOG.info("starting the Akka Serverless service");
    createAkkaServerless().start();
  }
}
