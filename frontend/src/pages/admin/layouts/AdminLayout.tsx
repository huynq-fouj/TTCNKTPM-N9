import { Outlet, useLocation, useNavigate } from "react-router-dom";
import Footer from "../components/Footer";
import Header from "../components/Header";
import StorageService from "../../../shared/services/StorageService";
import { useEffect } from "react";

export default function AdminLayout() {

    const isAdminLogin = StorageService.isAdmin();
    const loaction = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        if(!isAdminLogin) navigate('/login');
    }, [loaction]);

    return (
        <>
            <Header/>
            <Outlet/>
            <Footer/>
        </>
    )
}