package endpoints;

public class routes {



    public static String base_url="https://petstore.swagger.io/v2";

    //user routes
    public static String create_url=base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";


    //pet routes
    public static String pet_create_url=base_url+"/pet";
    public static String pet_get_url=base_url+"/pet/{petId}";
    public static String pet_update_url=base_url+"/pet/{petId}";
    public static String pet_delete_url=base_url+"/pet/{petId}";

}
