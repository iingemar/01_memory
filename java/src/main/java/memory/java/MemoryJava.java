package memory.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import memory.core.Memory;

public class MemoryJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("memory/resources");
    PlayN.run(new Memory());
  }
}
