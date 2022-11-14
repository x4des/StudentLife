public class Revision implements Evenement{
    @Override
    public boolean goCours() {
        return false;
    }

    public boolean goPause() {
        return false;
    }

    public boolean goRevision() {
        return true;
    }
}
