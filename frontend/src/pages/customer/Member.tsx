import { useNavigate } from "react-router-dom";
import StorageService from "../../shared/services/StorageService"
import { useEffect } from "react";
import toast from "react-hot-toast";


export default function Member() {

    const isLogin = StorageService.isLoggedIn();
    const user = StorageService.getUser();
    const navigate = useNavigate();

    useEffect(() => {
        if(!isLogin || user == null) {
            toast.error('Bạn chưa đăng nhập!');
            navigate('/login');
        }
    }, []);

    return (
        <>
            Member
        </>
    )
}