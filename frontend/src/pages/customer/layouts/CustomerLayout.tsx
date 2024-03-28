import { Outlet } from "react-router-dom";
import Footer from "../components/Footer";
import Header from "../components/Header";
import { BsChevronUp } from "react-icons/bs";
import './CustomerLayout.css';
import { useState } from "react";
import clsx from "clsx";

export default function CustomerLayout() {

    const [visible, setVisible] = useState(false);

    window.addEventListener('scroll', () => {
        const scrolled = document.documentElement.scrollTop; 
        if (scrolled > 200) setVisible(true); 
        else setVisible(false);
    });

    return (
        <>
            <div
                className={clsx('scroll-to-top',
                visible ? 'active' : '')}
                onClick={() => scrollTo({top: 0, behavior: 'smooth'})}>
                <BsChevronUp />
            </div>
            <Header/>
            <Outlet/>
            <Footer/>
        </>
    )
}