import { useNavigate } from "react-router-dom";
import StorageService from "../../shared/services/StorageService"
import { useEffect } from "react";


export default function Member() {

    const isLogin = StorageService.isLoggedIn();
    const user = StorageService.getUser();
    const navigate = useNavigate();

    useEffect(() => {
        if(!isLogin || user == null) navigate('/login');
    }, []);

    return (
        <>
            Member
        </>
    )
}