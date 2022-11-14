public class Pause implements  Evenement{
    @Override
    public boolean goPause() {
        return true;
    }

    public boolean goCours() {
        return true;
    }

    public boolean goRevision() {
        return false;
    }
}
