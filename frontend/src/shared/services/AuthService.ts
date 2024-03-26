import axios, { AxiosResponse } from "axios";
import { API_URL } from "../../api_url";

class AuthService {

    apiUrl = `${API_URL}/auth`;

    login(data: AuthRequest): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/login`, data);
    }

    register(data: AuthRequest): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/signup`, data);
    }

    refreshToken(data: any): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/refresh-token`, data);
    }

}

export default new AuthService();