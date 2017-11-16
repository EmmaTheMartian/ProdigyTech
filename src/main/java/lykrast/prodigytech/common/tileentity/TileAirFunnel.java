package lykrast.prodigytech.common.tileentity;

import lykrast.prodigytech.common.capability.CapabilityHotAir;
import lykrast.prodigytech.common.capability.IHotAir;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class TileAirFunnel extends TileEntity implements IHotAir {
	/** Internal check to prevent infinite checking loops (for whatever reason they could appear). */
	private boolean checked = false;
    /** The current temperature of the funnel */
    private int temperature;
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		if(capability==CapabilityHotAir.HOT_AIR && facing == EnumFacing.UP && !world.isBlockPowered(pos))
			return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if(capability==CapabilityHotAir.HOT_AIR && facing == EnumFacing.UP && !world.isBlockPowered(pos))
			return (T)this;
		return super.getCapability(capability, facing);
	}

	@Override
	public int getOutAirTemperature() {
		TileEntity tile = world.getTileEntity(pos.down());
		if (tile != null)
		{
			IHotAir capability = tile.getCapability(CapabilityHotAir.HOT_AIR, EnumFacing.UP);
			if (capability != null)
			{
				return capability.getOutAirTemperature();
			}
		}
		
		return 30;
	}

}