package se.resonantri.stargazerutil.utils.creativetab;

import com.google.common.base.Stopwatch;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import se.resonantri.stargazerutil.common.items.ModItems;
import se.resonantri.stargazerutil.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreativeTab extends CreativeTabBase {
    public static final CreativeTab stargazerUtils = new CreativeTab();
    private ItemStack defaultStack = ItemStack.EMPTY;
    private List<ItemStack> iconStacks;
    private int currentStackSize;
    private ItemStack currentStack;
    private Stopwatch watch;
    private Random random;


    public CreativeTab() {
        super(Constants.MODID, null);
        setBackgroundImageName("item_search.png");
        iconStacks = new ArrayList<>();
        watch = Stopwatch.createStarted();
        random = Constants.RANDOM;
        updateIcon();
        this.setFunction(this::getCurrentStack);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    private ItemStack getCurrentStack(){
        updateIcon();
        return currentStack;
    }

    private void updateIcon(){
        if (currentStackSize > 0){
            if (this.watch.elapsed(TimeUnit.MILLISECONDS) >= 1500L){
                this.watch.reset();
                this.watch.start();
                currentStack = iconStacks.get(random.nextInt(iconStacks.size()));
            } else {
                if (defaultStack == null || defaultStack.isEmpty()){
                    defaultStack = new ItemStack(Items.STICK);
                }
            }
            currentStack = defaultStack;
        }
    }

    public void setIconStacks(List<ItemStack> iconStacks){
        this.iconStacks = iconStacks;
        this.currentStackSize = this.iconStacks.size();
    }

    public void addIconStacks(List<ItemStack> iconStacks){
        for (int i = 0; i < 7; i++){
            ItemStack stack = new ItemStack(ModItems.itemInkwell);
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setInteger("ink", i * 3);
            stack.setTagCompound(tagCompound);
            this.iconStacks.add(stack);
        }
        this.currentStackSize = this.iconStacks.size();
    }

}
