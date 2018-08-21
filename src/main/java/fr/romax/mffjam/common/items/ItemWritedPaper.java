package fr.romax.mffjam.common.items;

import java.util.List;

import fr.romax.mffjam.MFFJam;
import fr.romax.mffjam.common.GuiHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.StringUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWritedPaper extends Item
{
	
	public ItemWritedPaper()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		ItemStack stack = player.getHeldItem(hand);
		if (world.isRemote && stack.hasTagCompound())
		{
			player.openGui(MFFJam.instance, GuiHandler.getHandID(hand), world, 0, 0, 0);
		}
		
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
        {
            String title = getTitle(stack);

            if (!StringUtils.isNullOrEmpty(title))
            {
                return title;
            }
        }
		
		return super.getItemStackDisplayName(stack);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (stack.hasTagCompound())
		{
			String author = getAuthor(stack);
			
			if (!StringUtils.isNullOrEmpty(author))
			{
				tooltip.add(TextFormatting.GRAY + I18n.format("page.byAuthor", author));
			}
		}
	}
	
	public static void setContent(ItemStack stack, String content, String title, String author)
	{
		initNBTTagCompound(stack);
		
		stack.getTagCompound().setString("text", content);
		stack.getTagCompound().setString("title", title);
		stack.getTagCompound().setString("author", author);
	}
	
	public static String getWritedText(ItemStack stack)
	{
		initNBTTagCompound(stack);
		return stack.getTagCompound().getString("text");
	}
	
	public static String getTitle(ItemStack stack)
	{
		initNBTTagCompound(stack);
		return stack.getTagCompound().getString("title");
	}
	
	public static String getAuthor(ItemStack stack)
	{
		initNBTTagCompound(stack);
		return stack.getTagCompound().getString("author");
	}
	
	private static void initNBTTagCompound(ItemStack stack)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
	}
	
}
