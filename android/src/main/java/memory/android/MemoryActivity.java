package memory.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import memory.core.Memory;

public class MemoryActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("memory/resources");
    PlayN.run(new Memory());
  }
}
