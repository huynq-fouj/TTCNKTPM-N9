import axios, { AxiosResponse } from "axios";
import { environment } from "../../environments/environment";

class AuthService {

    apiUrl = `${environment.apiUrl}/auth`;

    login(data: AuthRequest): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/login`, data);
    }

    signup(data: AuthRequest): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/signup`, data);
    }

    refreshToken(data: any): Promise<AxiosResponse<any, any>> {
        return axios.post(`${this.apiUrl}/refresh-token`, data);
    }

}

export default new AuthService();