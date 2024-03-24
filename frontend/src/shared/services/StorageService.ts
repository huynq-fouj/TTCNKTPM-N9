import { User } from "../interfaces/User";

const TOKEN = 'access_token';
const USER = 'user';

class StorageService {

    getAccessToken() : string | null {
        return window.localStorage.getItem(TOKEN);
    }

    setAccessToken(token: string) : void {
        window.localStorage.setItem(TOKEN, token);
    }

    delAccessToken() : void {
        window.localStorage.removeItem(TOKEN);
    }

    getUser() : User | null {
        const user = window.localStorage.getItem(USER);
        if(user) return JSON.parse(user);
        return null;
    }

    setUser(user: User) : void {
        window.localStorage.setItem(USER, JSON.stringify(user));
    }

    delUser() : void {
        window.localStorage.removeItem(USER);
    }

    isLoggedIn() : boolean {
        return this.getAccessToken() != null && this.getUser() != null;
    }

    isUser(): boolean {
        return this.isLoggedIn() && this.getUser()?.role === 'USER';
    }

    isAdmin(): boolean {
        return this.isLoggedIn() && this.getUser()?.role === 'ADMIN';
    }

    logOut() : void {
        this.delAccessToken();
        this.delUser();
    }

    clearStorage() : void {
        window.localStorage.clear();
    }

}

export default new StorageService();