import { Outlet, useNavigate } from "react-router-dom";
import Footer from "../components/Footer";
import Header from "../components/Header";
import StorageService from "../../../shared/services/StorageService";
import { useEffect } from "react";
import toast from "react-hot-toast";

export default function AdminLayout() {

    const navigate = useNavigate();

    useEffect(() => {
        const isAdminLogin = StorageService.isAdmin();
        if(!isAdminLogin) {
            toast.error('Bạn không thể truy cập trang này!');
            navigate('/login');
        }
    }, []);

    return (
        <>
            <Header/>
            <Outlet/>
            <Footer/>
        </>
    )
}