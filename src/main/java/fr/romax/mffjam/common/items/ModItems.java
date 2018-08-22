package fr.romax.mffjam.common.items;

import fr.romax.mffjam.common.registry.ItemsRegistry;

public class ModItems {

	public static ItemDagger dagger = new ItemDagger();
	public static ItemWrittenPaper written_paper = new ItemWrittenPaper();
	public static ItemMessageArrow message_arrow = new ItemMessageArrow();
	public static ItemSlimyPaper slimy_paper = new ItemSlimyPaper();

	
	public static void registerItems() {
		// A utiliser : ItemsRegistry.register(block, name);
		ItemsRegistry.register(dagger, "dagger");
		ItemsRegistry.register(written_paper, "written_paper");
		ItemsRegistry.register(message_arrow, "message_arrow");
		ItemsRegistry.register(slimy_paper, "slimy_paper");
	}
	
}
