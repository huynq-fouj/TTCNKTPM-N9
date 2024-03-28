import axios, { AxiosInstance } from "axios";
import { environment } from "../../environments/environment";
import HeaderService from "./HeaderService";

export const https: AxiosInstance = axios.create({
    baseURL: environment.apiUrl,
    headers: HeaderService.createAuthorizationHeader()
});