package factory;

public class OSFactory
{
    public IOperatingSystem getOS(String operatingSystem) {
        if (operatingSystem == null) {
            return null;
        }
        if (operatingSystem.equals("Mac OS")) {
            return new Mac();

        } else if (operatingSystem.equals("Windows OS")) {
            return new Windows();

        } else if (operatingSystem == "Linux OS") {
            return new Linux();
        }

        return null;
    }
}
