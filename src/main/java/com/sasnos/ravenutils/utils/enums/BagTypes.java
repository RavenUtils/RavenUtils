package com.sasnos.ravenutils.utils.enums;

public enum BagTypes {

  CLOTH("bag_cloth", 9, 2, 8, 18, 8, 66),
  LEATHER("bag_leather", 9, 4, 8, 18, 8, 102);

  private final String guiName;
  private final int inventoryWidth, inventoryHeight;
  private final int slotBackpackX, slotBackpackY;
  private final int slotPlayerX, slotPlayerY;

  BagTypes(String guiName, int inventoryWidth, int inventoryHeight, int slotBackpackX, int slotBackpackY, int slotPlayerX, int slotPlayerY) {
    this.guiName = guiName;
    this.inventoryWidth = inventoryWidth;
    this.inventoryHeight = inventoryHeight;
    this.slotBackpackX = slotBackpackX;
    this.slotBackpackY = slotBackpackY;
    this.slotPlayerX = slotPlayerX;
    this.slotPlayerY = slotPlayerY;
  }

  public String getGuiName() {
    return guiName;
  }

  public int getInventoryWidth() {
    return inventoryWidth;
  }

  public int getInventoryHeight() {
    return inventoryHeight;
  }

  public int getInventorySize() {
    return inventoryWidth * inventoryHeight;
  }

  public int getSlotBackpackX() {
    return slotBackpackX;
  }

  public int getSlotBackpackY() {
    return slotBackpackY;
  }

  public int getSlotPlayerX() {
    return slotPlayerX;
  }

  public int getSlotPlayerY() {
    return slotPlayerY;
  }

}
