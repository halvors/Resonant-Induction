package resonantinduction.electrical.multimeter;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class GraphL extends Graph<Long>
{
	public GraphL(int maxPoints)
	{
		super(maxPoints);
	}

	@Override
	public void queue(Long value)
	{
		queue += value;
	}

	public void doneQueue()
	{
		super.doneQueue();
		queue = 0L;
	}

	@Override
	public Long getDefault()
	{
		return 0L;
	}

	public void load(NBTTagCompound nbt)
	{
		NBTTagList nbtList = nbt.getTagList("DataPoints");

		for (int i = 0; i < nbtList.tagCount(); ++i)
		{
			NBTTagCompound nbtPoint = (NBTTagCompound) nbtList.tagAt(i);
			points.add(nbtPoint.getLong("data"));
		}
	}

	public NBTTagCompound save()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		NBTTagList data = new NBTTagList();

		for (long value : points)
		{
			NBTTagCompound nbtPoint = new NBTTagCompound();
			nbtPoint.setLong("data", value);

			data.appendTag(nbtPoint);
		}

		nbt.setTag("DataPoints", data);
		return nbt;
	}

}
