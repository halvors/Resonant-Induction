package resonantinduction.core.nei;

import resonant.lib.utility.LanguageUtility;
import resonantinduction.core.ResonantInduction.RecipeType;

public class RIGrinderRecipeHandler extends RITemplateRecipeHandler
{

	@Override
	public String getRecipeName()
	{
		return LanguageUtility.getLocal("resonantinduction.machine.grinder");
	}

	@Override
	public RecipeType getMachine()
	{
		return RecipeType.GRINDER;
	}
}
