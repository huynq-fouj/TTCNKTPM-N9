import { AxiosHeaders } from "axios";
import StorageService from "./StorageService";

class HeaderService {

    createAuthorizationHeader() : AxiosHeaders {
        return new AxiosHeaders().set(
            'Authorization', `Bearer ${StorageService.getAccessToken()}`
        );
    }

}

export default new HeaderService();