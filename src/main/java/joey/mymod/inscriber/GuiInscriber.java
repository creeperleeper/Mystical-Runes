package joey.mymod.inscriber;

import joey.mymod.MysticRune;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

    public class GuiInscriber extends GuiContainer {
        public static final int WIDTH = 180;
        public static final int HEIGHT = 152;

        private static final ResourceLocation background = new ResourceLocation(MysticRune.MODID, "textures/gui/inscriber.png");

        public GuiInscriber(TileInscriber tileEntity, ContainerInscriber container) {
            super(container);

            xSize = WIDTH;
            ySize = HEIGHT;
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            mc.getTextureManager().bindTexture(background);
            drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        }

}
