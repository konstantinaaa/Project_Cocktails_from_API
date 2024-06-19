package repository;


public class SingletonClass
{
    private static SingletonClass instance = new SingletonClass();

    private final FavoriteRepository favoriteRepository = new FavoriteRepository();
    private final WebApiRepository webApiRepository = new WebApiRepository();



    public static SingletonClass getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonClass();
        }
        return instance;
    }

    public FavoriteRepository getFavoriteRepository() {return favoriteRepository;}

    public WebApiRepository getWebApiRepository() {return webApiRepository;}

}
