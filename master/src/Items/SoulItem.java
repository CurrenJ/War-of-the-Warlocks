package Items;

import javax.swing.JPanel;

public class SoulItem extends Item{
	private int bobTick = 0;
	private int bobMax = 10;

	public SoulItem(int x, int y, JPanel panel) {
		super(x, y, 7, 12, 20, "soul", 8, panel, 20);
		disableGravity = true;
	}
	
	public void bob(){
		//Makes the item appear to bob up and down.
		//Many graphics, such hard, will do later.
	}
	
	@Override
	public void advanceFrame(){
		if(curPauseNum != animationPause){
			curPauseNum++;
		}
		else {
			curPauseNum = 0;
			
			if(curFrame + 1 != animationFrames){
				curFrame++;
			}
			else curFrame = 0;
		}
		
		bob();
		
//		if(curFrame < animationFrames / 4  * 2 && curFrame > animationFrames / 4 && curPauseNum == 0){
//			yPos += 1;
//		}
//		else if(curFrame >= animationFrames / 4 * 3 && curPauseNum == 0){
//			yPos -= 1;
//		}
	}

}
