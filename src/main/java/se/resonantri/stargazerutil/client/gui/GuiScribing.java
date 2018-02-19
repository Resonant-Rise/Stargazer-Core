package se.resonantri.stargazerutil.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import se.resonantri.stargazerutil.common.containers.ContainerScribing;
import se.resonantri.stargazerutil.common.tiles.TileScribing;
import se.resonantri.stargazerutil.utils.Constants;

public class GuiScribing extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Constants.MODID, "textures/gui/gui_scribing.png");

    public GuiScribing(TileScribing scribeTable, ContainerScribing container) {
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
