import axios from "axios";
import { API_URL } from "../../api_url";

class AuthService {

    apiUrl = `${API_URL}/auth`;

    login(authRequest: any) {
        return axios.post(`${this.apiUrl}/login`, authRequest);
    }

    register(authRequest: any) {
        return axios.post(`${this.apiUrl}/signup`, authRequest);
    }

}

export default new AuthService();