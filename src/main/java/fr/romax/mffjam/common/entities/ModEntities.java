package fr.romax.mffjam.common.entities;

import fr.romax.mffjam.MFFJam;
import fr.romax.mffjam.client.renderers.entity.RenderHangingMessage;
import fr.romax.mffjam.client.renderers.entity.RenderMessageArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = MFFJam.MODID)
public class ModEntities
{
	
	public static void registerEntities()
	{
		EntityRegistry.registerModEntity(new ResourceLocation(MFFJam.MODID, "message_arrow"), EntityMessageArrow.class, "message_arrow", 0, MFFJam.instance, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(MFFJam.MODID, "hanging_message"), EntityHangingMessage.class, "hanging_message", 1, MFFJam.instance, 160, Integer.MAX_VALUE, false);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMessageArrow.class, RenderMessageArrow::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityHangingMessage.class, RenderHangingMessage<EntityHangingMessage>::new);
	}
	
}