package kg.seit.company_project_rest_api_jwt.mapper;

/**
 * @author seiitbeknarynbaev
 */
public interface Convert <MODEL,REQUEST,RESPONSE>{

    MODEL convert(REQUEST request);

    RESPONSE deConvert(MODEL model);
}
