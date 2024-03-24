import { Outlet } from "react-router-dom";
import Footer from "./admin/Footer";
import Header from "./admin/Header";

export default function AdminLayout() {

    

    return (
        <>
            <Header/>
                <Outlet/>
            <Footer/>
        </>
    )
}