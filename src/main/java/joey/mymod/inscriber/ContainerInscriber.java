package joey.mymod.inscriber;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerInscriber extends Container {

    private TileInscriber te;

    public ContainerInscriber(IInventory playerInventory, TileInscriber te) {
        this.te = te;

        // This container references items out of our own inventory (the 9 slots we hold ourselves)
        // as well as the slots from the player inventory so that the user can transfer items between
        // both inventories. The two calls below make sure that slots are defined for both inventories.
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 18;
        int y = 23;

        // Add our own slots
        int slotIndex = 0;
        //Input
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); //Slate Spot
        x =53; y=5;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); x+= 18; //Upper Left
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)) ;x+=18;  //Upper Middle
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));  //Upper Right

        x=53; y=23;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); x+=18; //Middle Left
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); x+=18;  //Middle Middle
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));  //Middle Right

        x=53; y=41;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); x+=18; //Lower Left
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); x+=18; //Lower Middle
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));  //Lower Right

        //Output
        x=143; y=19;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y)); //Output


        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 18;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < TileInscriber.SIZE) {
                if (!this.mergeItemStack(itemstack1, TileInscriber.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, TileInscriber.SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.canInteractWith(playerIn);
    }
    }

